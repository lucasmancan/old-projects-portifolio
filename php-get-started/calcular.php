<?php
$num1 = $_POST['num1'];
$num2 = $_POST['num2'];
$operacao = $_POST['operacao'];
include_once "Calculadora.php";


$calculador = new Calculadora();
$calculador-> setNum1($num1);
$calculador-> setNum2($num2);

switch($operacao){
    case "somar":
    $calculador-> somar();
    break;
    case "subtrair":
    $calculador-> subtrair();
    break;
    case "multiplicar":
    $calculador-> multiplicar();
    break;
    case "dividir":
    $calculador-> dividir();
    break;
    default:
    echo "opção inválida";
    break;
}

echo $calculador->getTotal();

?>