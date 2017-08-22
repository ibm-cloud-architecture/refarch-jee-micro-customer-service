### Overview

CustomerOrderService is a microservice that redirects service requests from BFF layer to Legacy Backend Layer. This service is introduced to implement [Strangler Pattern] (https://www.ibm.com/developerworks/cloud/library/cl-strangler-application-pattern-microservices-apps-trs/index.html). Currently it only redirects the requests to EJB layer. In future it can be used to redirect requests to new implementations of services using new technologies e.g. nodejs and nosql

The CustomerOrderService exposes the following interfaces
- /Customer
- /Customer/Address
- /Customer/OpenOrder/LineItem
- /Customer/OpenOrder/LineItem/id
- /Customer/OpenOrder
- /Customer/Orders
- /Customer/TypeForm
- /Customer/Info

<br />

### Configuration

One configuration parameter that this micro service requires is the IP address of the EJB services host. The EJB services host IP address is specified in the environment variables of this application. The environment variable goes as EJBServiceIP=""

<br />

### Build WAR using Maven
1. Ensure maven is installed
2. On command prompt, navigate to CustomerOrderService project
3. Run "mvn clean package" command
4. CustomerOrderService-0.1.war is created under CustomerOrderService/target directory
5. Use this war file for deploying the CustomerOrderService module on app server

<br>

### Security Configuration in server.xml
The backend services are secured with basic authentication. Hence the intermediate REST service layer also needs to be secured. Add the following Basic Registry in server.xml file

    <basicRegistry id="basic" realm="BasicRealm"> 
        <!-- <user name="yourUserName" password="" />  -->
        <group name="SecureShopper">
        	<member name="rbarcia"/>
        	<member name="kbrown"/>
        </group>
        <user name="rbarcia" password="{xor}PTNvKDk2LDc="/> <!-- Refer parent documentation for passwords for these users -->
        <user name="kbrown" password="{xor}PTNvKDk2LDc="/> <!-- Refer parent documentation for passwords for these users -->
    </basicRegistry>
    
<br>   
<b>Challenges resolved:</b>
<br>
1) Client application expects "ETag" header and it's value to be present in response headers. Hence had to 1) Pass the value from client to EJB Layer and then 2) Extract the Etag header value from response of EJB layer to the client (again as ETag header in response to client)
