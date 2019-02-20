FROM bitnami/oraclelinux-extras:7-r263
LABEL maintainer "Bitnami <containers@bitnami.com>"
# Install required system packages and dependencies
RUN install_packages cyrus-sasl-lib fontconfig glibc keyutils-libs krb5-libs libcom_err libcurl libgcc libidn libselinux libssh2 nspr nss nss-softokn-freebl nss-util openldap openssl-libs pcre unzip zlib wget

# Downloading Java
RUN wget --no-cookies --no-check-certificate --header "Cookie: oraclelicense=accept-securebackup-cookie" "https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.rpm" -O /tmp/jdk-8u201-linux-x64.rpm

RUN yum -y install /tmp/jdk-8u201-linux-x64.rpm
RUN alternatives --install /usr/bin/java jar /usr/java/latest/bin/java 200000
RUN alternatives --install /usr/bin/javaws javaws /usr/java/latest/bin/javaws 200000

RUN alternatives --install /usr/bin/javac javac /usr/java/latest/bin/javac 200000
ENV JAVA_HOME /usr/java/latest

RUN bitnami-pkg install java-1.8.201-0 --checksum e71b797ceaaf8b0641d1641df129cea10124b058bc24d4ed74738725fabfb8c9
RUN bitnami-pkg install git-2.20.1-20 --checksum 160b41e17f0414c1206e97cc1eef3720596c0229922b68d4ded4a69bfc08cc51
RUN bitnami-pkg unpack jenkins-2.150.3-0 --checksum c7d72ad858768343374e28eb336ec7ef49973381cf3bd6e18797881490ebd363

RUN mkdir -p /usr/share/jenkins/ref

COPY rootfs /
RUN ln -sf /install-plugins.sh /usr/local/bin/install-plugins.sh
ENV BITNAMI_APP_NAME="jenkins" \
    BITNAMI_IMAGE_VERSION="2.150.3-ol-7-r1" \
    DISABLE_JENKINS_INITIALIZATION="no" \
    JAVA_OPTS="" \
    JENKINS_HOME="/opt/bitnami/jenkins/jenkins_home" \
    JENKINS_PASSWORD="admin" \
    JENKINS_USERNAME="admin" \
    PATH="/opt/bitnami/java/bin:/opt/bitnami/git/bin:$PATH"

# get maven 3.2.2 and verify its checksum
RUN wget --no-verbose -O /tmp/apache-maven-3.2.2.tar.gz http://archive.apache.org/dist/maven/maven-3/3.2.2/binaries/apache-maven-3.2.2-bin.tar.gz; \echo "87e5cc81bc4ab9b83986b3e77e6b3095 /tmp/apache-maven-3.2.2.tar.gz" | md5sum -c
# install maven
RUN tar xzf /tmp/apache-maven-3.2.2.tar.gz -C /opt/; \
   ln -s /opt/apache-maven-3.2.2 /opt/maven; \
   ln -s /opt/maven/bin/mvn /usr/local/bin; \
   rm -f /tmp/apache-maven-3.2.2.tar.gz
ENV MAVEN_HOME /opt/maven
EXPOSE 8080 8443 50000

ENTRYPOINT [ "/app-entrypoint.sh" ]
CMD [ "/run.sh" ]
