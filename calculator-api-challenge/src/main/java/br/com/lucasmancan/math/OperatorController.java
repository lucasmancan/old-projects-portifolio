package br.com.lucasmancan.math;

import br.com.lucasmancan.math.implementations.interfaces.Operator;
import br.com.lucasmancan.math.models.Operation;
import br.com.lucasmancan.math.models.OperationResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class OperatorController {

    /*
    * Check global application exception handler
    * */
    @PostMapping
    @ResponseBody
    public OperationResult calculate(@RequestBody @Valid Operation operation){

        Operator operator =  OperatorFactory.create(operation.getAcao());

        return OperationResult.valueOf(operator.calculate(operation.getNumeros()));
    }
}
