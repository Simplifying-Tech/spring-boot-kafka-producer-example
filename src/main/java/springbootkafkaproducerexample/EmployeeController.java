package springbootkafkaproducerexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
 
    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;
    //private KafkaTemplate<String, String> kafkaTemplate;
 
    private static final String TOPIC = "kafkatopicspring";
 
    @GetMapping("/producer/{firstname}")
    public String post(@PathVariable("firstname") final String firstname) {
 
       kafkaTemplate.send(TOPIC, new Employee(firstname, "depp", 1001));
        //kafkaTemplate.send(TOPIC, firstname);
 
        return "Published kafka message successfully";
    }
}
