package local;

//import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

//@ApplicationScoped
public class CamelRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("servlet://hello?matchOnUriPrefix=true")
                .setBody(constant("HelloWorld"));

        from("netty4-http:http://0.0.0.0:8999/greeter")
          .to("netty4-http:http://localhost:8080/greeter/hello");
    }

}
