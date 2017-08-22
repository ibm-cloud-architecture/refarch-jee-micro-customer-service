FROM registry.ng.bluemix.net/ibmliberty:latest

COPY target/CustomerOrderService-0.1.war /opt/ibm/wlp/usr/servers/defaultServer/dropins/
COPY server.xml /opt/ibm/wlp/usr/servers/defaultServer/
COPY GeneratedSSLInclude.xml /opt/ibm/wlp/usr/servers/defaultServer/
COPY ltpa.keys /opt/ibm/wlp/usr/servers/defaultServer/
COPY key.jks /opt/ibm/wlp/usr/servers/defaultServer/resources/security/

EXPOSE 9080
EXPOSE 9443

CMD ["/opt/ibm/docker/docker-server", "run", "defaultServer"]
