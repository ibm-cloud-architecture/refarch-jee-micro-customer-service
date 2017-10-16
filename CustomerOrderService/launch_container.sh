nohup /opt/ibm/docker/docker-server run defaultServer > /dev/null 2>&1 &
/filebeat-5.6.3-linux-x86_64/filebeat -e -c /tmp/filebeat.yml -d "publish"
