FROM registry.ng.bluemix.net/ibmliberty:latest

COPY target/CustomerOrderService-0.1.war /opt/ibm/wlp/usr/servers/defaultServer/dropins/
COPY server.xml /opt/ibm/wlp/usr/servers/defaultServer/
COPY GeneratedSSLInclude.xml /opt/ibm/wlp/usr/servers/defaultServer/
COPY ltpa.keys /opt/ibm/wlp/usr/servers/defaultServer/
COPY key.jks /opt/ibm/wlp/usr/servers/defaultServer/resources/security/

RUN wget https://artifacts.elastic.co/downloads/beats/filebeat/filebeat-5.6.3-linux-x86_64.tar.gz
RUN tar -xvf filebeat-5.6.3-linux-x86_64.tar.gz
COPY filebeat.yml /tmp/
COPY launch_container.sh /tmp
RUN chmod go-w /tmp/filebeat.yml
RUN chmod +x /tmp/launch_container.sh

EXPOSE 9080
EXPOSE 9443

CMD ["/bin/bash","/tmp/launch_container.sh"]
