<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
 
<form method ="get" action = "if_elseGUI.php">
<input type = "number" name = "number" >
<button type="submit">Par ou Impar</button>
</form>
<?php
    include "if_else.php";
    $number = $_GET['number'];

    if(is_numeric($number) && isset($number))
    echo parImpar($number);
    else
    echo "digite um numero válido";

    ?>
</body>
</html>