<?php
$mysql = new mysqli("localhost","root","","mejoresventas");
if($mysql -> connect_error){
    die("Error de conexion");
}
else{
    //echo "conexion exitosia";
}