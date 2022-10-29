<?php
if ($_SERVER["REQUEST_METHOD"]=="POST"){
    require_once 'conexion.php';
    $dni=$_POST["dni"];
    $nombre=$_POST["nombre"];
    $telefono=$_POST["telefono"];
    $direccion=$_POST["direccion"];
    $usuario_id=$_POST["usuario_id"];
    $query = "INSERT INTO cliente(dni,nombre,telefono,direccion,usuario_id)
    values ('".$dni."','".$nombre."','".$telefono."','".$direccion."','".$usuario_id."') ";
    $resultado=$mysql -> query($query) ;  
    if($resultado == true){
        echo "el usuario se inserto de forma exitosa ";
    }
    else{
        echo "error al insertar el usuario ";
    }
}
