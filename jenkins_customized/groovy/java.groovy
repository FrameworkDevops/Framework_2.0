import jenkins.model.*
import hudson.model.*
import groovy.io.FileType

name = "Java";
home = "/usr/java/latest";
list = null;

dis = new hudson.model.JDK.DescriptorImpl();
dis.setInstallations( new hudson.model.JDK(name, home));
dis.save()
