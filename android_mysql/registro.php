<?php
    if($_SERVER["REQUEST_METHOD"]=="GET"){
        require_once 'conexion.php';
        $id=$_GET['idusuario'];
        $query="SELECT * FROM usuario where idusuario = '".$id."'";
        $resultado = $mysql ->query($query);
        if($mysql -> affected_rows > 0 ){
            while($row = $resultado -> fetch_assoc()){
                $array = $row;
            }
            echo json_encode($array);
        }else{
            echo "no hay registros";
        }
        $resultado -> close();
        $mysql -> close();
    }
