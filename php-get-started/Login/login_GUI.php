<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <style>
        .container{
            max-width:300px;
            
        }
    </style>
</head>
<body>
    <div class="container">
<div class = "row">
   
        <h1>Entrar no Sistema</h1>
 <form  action="login_handler.php" method ="post">
     <div class = "form-group">
    <label for="user">Usuário</label>
    <input class= "form-control" name = "user" type = "text">
</div>
<div class = "form-group">
    <label for="user">Senha</label>
    <input class= "form-control" name = "password" type = "password">
</div>
<button type="submit" class="btn btn-success" value="Entrar">Entrar</button>
</div>
 <form>

    <div>
</body>
</html>