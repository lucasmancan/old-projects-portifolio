<?php

class Calculadora{
    private $num1;
    private $num2;
    private $total;

    function _construct(){
        $this-> num1 = 0;
        $this-> num2 = 0;
        $this-> total = 0;
    }
    //get and set
    public function setNum1($num1){
        $this-> num1 =  $num1;
    }

    public function setNum2($num2){
        $this-> num2 =  $num2;
    }

    public function getNum1(){
        return $this-> num1;
    }
    public function getNum2(){
        return $this-> num2;
    }

    public function somar(){
        $this-> total = $this->num1 + $this->num2;
    }
    public  function subtrair(){
        $this-> total =$this->num1 - $this->num2;
    }
    public function multiplicar(){
        $this-> total = $this->num1 * $this->num2;
    }
    public function dividir(){
        $this-> total = $this->num1 / $this->num2;
    }

    public function getTotal(){
        return $this-> total;
    }
}
?>