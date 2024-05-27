package jfinal;

import com.jfinal.config.*;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

    // 配置常量值
    public void configConstant(Constants me) {
        me.setDevMode(true);
    }

    // 配置路由
    public void configRoute(Routes me) {
        me.add("/jfinal", MyController.class);
    }

    public void configEngine(Engine me) {
    }

    public void configPlugin(Plugins me) {
    }

    public void configInterceptor(Interceptors me) {
    }

    public void configHandler(Handlers me) {
    }

    // 应用程序启动后的回调方法
    public void afterJFinalStart() {
        System.out.println("JFinal started.");
    }

    // 应用程序关闭前的回调方法
    public void beforeJFinalStop() {
        System.out.println("JFinal stopping.");
    }
}
