import jenkins.model.*
import hudson.plugins.sonar.*
import hudson.plugins.sonar.model.*

def inst = Jenkins.getInstance()
def desc = inst.getDescriptor("hudson.plugins.sonar.SonarPublisher")
def sinst = new SonarInstallation(
  "sonar4.5.1",
  false,
  "http://localhost:9000/",
  "jdbc:mysql://localhost:3306/sonar",
  "com.mysql.jdbc.Driver",
  "sonar",
  "sonar",
  "",
  "-Dsonar.sourceEncoding=\"UTF-8\"",
  new TriggersConfig(),
  "admin",
  "admin"
)

desc.setInstallations(sinst)
desc.save()
