package com.mycompany.creacionescaleb.util;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONObject;

/**
 *
 * @author USER
 */
public class ApiReniec {

    // Atributos
    private String dni;
    private String respuesta = "9999";
    private String nombre;
    private String paterno;
    private String materno;
    private int edad;
    private String genero;
    private String feNacimiento;
    private String fotoPersona;
    private boolean Obtenerfoto;

    public ApiReniec(String dni) {
        this.dni = dni;
        this.Obtenerfoto = false;
        this.fotoPersona = null;
        // Llamos al metodo apenas se crea la instancia
        try {
            buscarPorDNI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Constructor con la opción de foto
    public ApiReniec(String dni, boolean obtenerfoto) {
        this.dni = dni;
        this.Obtenerfoto = obtenerfoto;
        // Llamos al metodo apenas se crea la instancia
        try {
            buscarPorDNI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFeNacimiento() {
        return feNacimiento;
    }

    public void setFeNacimiento(String feNacimiento) {
        this.feNacimiento = feNacimiento;
    }

    public String getFotoPersona() {
        return fotoPersona;
    }

    public void setFotoPersona(String fotoPersona) {
        this.fotoPersona = fotoPersona;
    }

    // Metodo que establece los valores correspondientes a los atributos
    public void buscarPorDNI() throws IOException {
        try {
            URL url = new URL("http://app20.susalud.gob.pe/wb-casilla/data/consultaws.htm");
            Map<String, Object> payload = new LinkedHashMap<>();
            payload.put("txtDocumento", dni);
            payload.put("codigoDocumento", "01");

            StringBuilder postData = new StringBuilder();
            for (Map.Entry<String, Object> payloads : payload.entrySet()) {
                if (postData.length() != 0) {
                    postData.append('&');
                }
                postData.append(URLEncoder.encode(payloads.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf(payloads.getValue()), "UTF-8"));
            }

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoInput(true);
            conn.setDoOutput(true);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream());
            writer.write(postData.toString());
            writer.flush();

            Scanner scanner = new Scanner(conn.getInputStream());
            StringBuilder response = new StringBuilder();

            // Se recorre la respuesta de la api y con el metodo append vamos agregando linea la respuesta a la varaiable response
            while (scanner.hasNextLine()) {
                response.append(scanner.nextLine());
            }

            JSONObject jsonObject = new JSONObject(response.toString());
            JSONObject dataJson = jsonObject.getJSONObject("dataJson");
            JSONObject persona = dataJson.getJSONObject("persona");
            String resultado = persona.getString("resultado"); // Se busca la key coRespuesta y se obtiene el valor
            if (resultado.equals("OK")) { // Si la respuesta es "", es decir, es correcta, se obtiene los demas valores
                setRespuesta("0000");
                String apePaterno = persona.getString("apPaterno");
                setPaterno(apePaterno);
                String apeMaterno = persona.getString("apMaterno");
                setMaterno(apeMaterno);
                String preNombres = persona.getString("preNombres");

                preNombres = preNombres.replace(apePaterno, "");
                preNombres = preNombres.replace(apeMaterno, "");
                preNombres = preNombres.substring(0, preNombres.length()-2);
                setNombre(preNombres);

                String feNac = persona.getString("feNac");
                setFeNacimiento(feNac);
                // Define un formato para la fecha
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                // Convierte la cadena de fecha de nacimiento a un objeto LocalDate
                LocalDate fechaNac = LocalDate.parse(feNac, formatter);
                // Obtiene la fecha actual
                LocalDate fechaActual = LocalDate.now();
                // Calcula la diferencia entre la fecha de nacimiento y la fecha actual
                Period periodo = Period.between(fechaNac, fechaActual);
                // Obtiene el número de años del periodo
                int edadd = periodo.getYears();
                setEdad(edadd);

                String coGenero = persona.getString("coGenero");
                if (coGenero.equals("M")) {
                    setGenero("MASCULINO");
                } else if (coGenero.equals("F")) {
                    setGenero("FEMENINO");
                }

                if (Obtenerfoto) {
                    // Cerramos la conexión anterior
                    conn.disconnect();
                    scanner.close();
                    System.out.println("Obteniendo foto");
                    // Obtenemos foto
                    URL urlFoto = new URL(String.format("http://161.132.47.31:5000/proyectoucv/%s", dni));
                    conn = (HttpURLConnection) urlFoto.openConnection();
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setDoOutput(true);

                    scanner = new Scanner(conn.getInputStream());
                    StringBuilder responseFoto = new StringBuilder();

                    // Se recorre la respuesta de la API y con el método append vamos agregando línea la respuesta a la variable response
                    while (scanner.hasNextLine()) {
                        // Almacena la línea leída en una variable
                        String line = scanner.nextLine();
                        // Imprime y procesa la línea almacenada
                        responseFoto.append(line);
                    }

                    // Procesa la respuesta JSON después de haber leído todas las líneas
                    JSONObject jsonObject2 = new JSONObject(responseFoto.toString());
                    String coRespuesta = jsonObject2.getString("coRespuesta");
                    if (coRespuesta.equals("0000")) {
                        String fot = jsonObject2.getString("foto");
                        setFotoPersona(fot);
                    }
                }
            }
        } catch (IOException e) {
            throw e;
        }
    }
}
