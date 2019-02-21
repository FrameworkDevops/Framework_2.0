import jenkins.model.*
import org.jfrog.*
import org.jfrog.hudson.*
import org.jfrog.hudson.util.Credentials;

def inst = Jenkins.getInstance()
def desc = inst.getDescriptor("org.jfrog.hudson.ArtifactoryBuilder")
def deployerCredentials = new Credentials("admin", "password")
def resolverCredentials = new Credentials("", "")
def sinst = [new ArtifactoryServer(
  "server-id",
  "http://localhost:8081/artifactory",
  deployerCredentials,
  resolverCredentials,
  300,
  false )
]

desc.setArtifactoryServers(sinst)
desc.save()
