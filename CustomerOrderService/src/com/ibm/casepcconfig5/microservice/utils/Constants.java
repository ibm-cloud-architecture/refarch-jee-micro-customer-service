package com.ibm.casepcconfig5.microservice.utils;

public class Constants {
	
	
	private static final String ip = (System.getenv("EJBServiceIP") == null ? "169.44.18.102":System.getenv("EJBServiceIP"));
	public static final String PRODUCT_ID_URL = "http://" + ip + "/ProductSearchServiceWeb/jaxrs/Product/";

	public static final String CUSTOMER_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer";
	public static final String CUSTOMER_ADDRESS_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/Address";
	public static final String CUSTOMER_ADDRESS_OPENORDER_LINEITEM_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/OpenOrder/LineItem";
	public static final String CUSTOMER_ADDRESS_OPENORDER_LINEITEM_ID_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/OpenOrder/LineItem/";
	public static final String CUSTOMER_OPENORDER_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/OpenOrder";
	public static final String CUSTOMER_ORDERS_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/Orders";
	public static final String CUSTOMER_TYPEFORM_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/TypeForm";
	public static final String CUSTOMER_INFO_URL = "http://" + ip + "/CustomerOrderServicesWeb/jaxrs/Customer/Info";
	
}
