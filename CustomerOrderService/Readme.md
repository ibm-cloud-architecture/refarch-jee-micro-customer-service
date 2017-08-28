### Overview

This is an intermediate REST interface module which redirects the REST requests to the Legacy Backend Layer. This intermediate layer is introduced so as to absorb any future changes to either the UI layer or the backend layer. 

The CustomerOrderService exposes the following interfaces

- /Customer
- /Customer/Address
- /Customer/OpenOrder/LineItem
- /Customer/OpenOrder/LineItem/id
- /Customer/OpenOrder
- /Customer/Orders
- /Customer/TypeForm
- /Customer/Info

<br>

<b>Build WAR using Maven</b>
- Ensure maven is installed
- On command prompt, navigate to CustomerOrderService project
- Run "mvn clean package" command
- CustomerOrderService-0.1.war is created under CustomerOrderService/target directory
- Use this war file for deploying the CustomerOrderService module on app server

<br>

<b>Security Configuration in server.xml</b><br>
The backend services are secured with basic authentication. Hence the intermediate REST service layer also needs to be secured. Add the following Basic Registry in server.xml file

    <ldapRegistry baseDN="dc=purplecompute,dc=com" bindDN="cn=admin,dc=purplecompute,dc=com" bindPassword="{xor}Dz4sLChvLTs=" host="<ldap-server ip>" id="ldap" ignoreCase="true" ldapType="Custom" port="31252" realm="<ldap-server ip>:31252" searchTimeout="8m">
     
        <contextPool enabled="true" initialSize="1" maxSize="0" preferredSize="3" timeout="0s" waitTime="3000ms"/>
        
        <ldapCache>
            <attributesCache enabled="true" size="4000" sizeLimit="2000" timeout="1200s"/>
            <searchResultsCache enabled="true" resultsSizeLimit="1000" size="2000" timeout="600s"/>
        </ldapCache>
    
    </ldapRegistry>
    
<br>   
<b>Challenges resolved:</b>
<br>
1) Client application expects "ETag" header and it's value to be present in response headers. Hence had to 1) Pass the value from client to EJB Layer and then 2) Extract the Etag header value from response of EJB layer to the client (again as ETag header in response to client)
