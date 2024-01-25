@Grab('org.codehaus.groovy:groovy-json:3.0.20')
import groovy.json.JsonSlurper

def URL = new URL("https://api.open-meteo.com/v1/forecast?latitude=46.62&longitude=8.04&current=temperature_2m,wind_speed_10m&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m").openConnection();
def getRC = URL.getResponseCode();
println(getRC);

if (getRC.equals(200)) {
  println(URL.getInputStream().getText());
}

def jsonSlurper = new JsonSlurper();
def object = jsonSlurper.parseText(URL.getInputStream().getText());
