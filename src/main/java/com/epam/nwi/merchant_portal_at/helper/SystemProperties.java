package com.epam.nwi.merchant_portal_at.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class SystemProperties {
public static Properties prop = new Properties();
static InputStream iStream = null;

@SuppressWarnings("finally")
public static String getProperty(String propertyName)
{
	String property = null;
	try
	{
		iStream = new FileInputStream("config.properties");
		prop.load(iStream);
		property = prop.getProperty(propertyName);
	}
	catch (IOException iex)
	{
		iex.printStackTrace();
	}
	finally
	{
		if (iStream != null) {
			try {
				iStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
		return property;
}
}
}
