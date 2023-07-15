<?php
require_once('check_login.php');

$user = $_POST['user'];
$password = $_POST['password'];

$validate = Entrar($user, $password);

if($validate){
    echo 'logado';
}else{
    echo 'deslogado';
}

?>