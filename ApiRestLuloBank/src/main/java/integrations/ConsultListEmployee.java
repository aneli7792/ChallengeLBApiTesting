package integrations;

import models.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.List;

import static utils.UrlServices.LIST_EMPLOYEES;

public class ConsultListEmployee implements Task {

    public static ConsultListEmployee of() {
        return Tasks.instrumented(ConsultListEmployee.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(Get.resource(LIST_EMPLOYEES.toString()));
        SerenityRest.lastResponse().prettyPrint();
        List<Employee> employees = SerenityRest.lastResponse().jsonPath().getList("data", Employee.class);
        actor.remember("status", SerenityRest.lastResponse().jsonPath().getString("status"));
    }
}
