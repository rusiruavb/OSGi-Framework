package osgi_service_subscriber;

import com.pulisher_service.ServicePublish;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public class ServiceActivator implements BundleActivator {

	ServiceReference serviceReference;

	public void start(BundleContext context) throws Exception {
		System.out.println("Service subscriber start");
		serviceReference = context.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePulish = (ServicePublish)context.getService(serviceReference);
		System.out.println(servicePulish.publishService());
	}

	public void stop(BundleContext context) throws Exception {
		System.out.println("Service subscriber stopped");
		context.ungetService(serviceReference);
	}

}
