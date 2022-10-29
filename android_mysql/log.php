<?php
    if($_SERVER["REQUEST_METHOD"]=="POST"){
        require_once 'conexion.php';
        $id=$_POST['idcliente'];
        $dni=$_POST['dni'];
        $sentencia = $conexion -> prepare("SELECT * FROM cliente WHERE idcliente = ? and dni = ? ");
        $sentencia -> bind_param('ss',$id,$dni );
        $sentencia -> execute();
        $resultado = $sentencia -> get_result();
        if($fila = $resultado -> fetch_assoc()){
            echo json_encode($fila, JSON_UNESCAPED_UNICODE);  
            print("siu");
        }
        $sentencia ->close();
        $conexion -> close();
    }