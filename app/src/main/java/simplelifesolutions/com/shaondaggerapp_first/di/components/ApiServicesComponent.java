package simplelifesolutions.com.shaondaggerapp_first.di.components;

import dagger.Component;
import simplelifesolutions.com.shaondaggerapp_first.Retrofit.APIInterface;
import simplelifesolutions.com.shaondaggerapp_first.di.modules.ModuleApiService;

@Component(modules = {ModuleApiService.class})
public interface ApiServicesComponent {

    APIInterface getApiService();
}
