package integrations;

import io.restassured.http.ContentType;
import models.Employee;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import static utils.UrlServices.SAVE_EMPLOYEE;

public class CreateEmployee implements Task {

    private Employee employee;

    public CreateEmployee(Employee employee) {
        this.employee = employee;
    }

    public static CreateEmployee on(Employee employee) {
        return Tasks.instrumented(CreateEmployee.class, employee);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Datos del empleado id:" + employee.getEmployeeId().toString());
        System.out.println("name:" + employee.getEmployeeName().toString());
        System.out.println("Salario:" + employee.getEmployeeSalary().toString() );
        System.out.println(" edad:" + employee.getEmployeeAge().toString());
        actor.attemptsTo(
                Post.to(SAVE_EMPLOYEE.toString())
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body(employee))
        );
        SerenityRest.lastResponse().prettyPrint();
        actor.remember("status", SerenityRest.lastResponse().jsonPath().getString("status"));
        Employee employee = SerenityRest.lastResponse().jsonPath().getObject("data", Employee.class);
        actor.remember("id", employee.getEmployeeId());
    }
}
