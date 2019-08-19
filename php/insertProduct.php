﻿<?php 
    error_reporting(E_ALL); 
    ini_set('display_errors',1); 
    include('dbcon.php');
    
    $android = strpos($_SERVER['HTTP_USER_AGENT'], "Android");

    if( (($_SERVER['REQUEST_METHOD'] == 'POST') && isset($_POST['submit'])) || $android )
    {
        // 안드로이드 코드의 postParameters 변수에 적어준 이름을 가지고 값을 전달 받습니다.
        $id=$_POST['id'];
        $name=$_POST['name'];
        $category=$_POST['category'];
        $length=$_POST['length'];
        $image=$_POST['image'];
        $price=$_POST['price'];
        $size=$_POST['size'];
        $color=$_POST['color'];
        $fabric=$_POST['fabric'];
        $pattern=$_POST['pattern'];
        $detail=$_POST['detail'];
        
        if(!isset($errMSG)) // 이름과 나라 모두 입력이 되었다면 
        {
            try{
                // SQL문을 실행하여 데이터를 MySQL 서버의 person 테이블에 저장합니다. 
<<<<<<< HEAD
                $stmt = $con->prepare('INSERT INTO Product(id, name, category, lengthimage, price, size, color, fabric, pattern, detail) VALUES(:id, :name, :category, :length, :image, :price, :size, :color, :fabric, :pattern, :detail )');
                $stmt->bindParam(':id', $id);
                $stmt->bindParam(':name', $name);
                $stmt->bindParam(':category', $category);
                $stmt->bindParam(':length', $length);
                $stmt->bindParam(':image', $image);
                $stmt->bindParam(':price', $price);
                $stmt->bindParam(':size', $size);
                $stmt->bindParam(':color', $color);
                $stmt->bindParam(':fabric', $fabric);
                $stmt->bindParam(':pattern', $pattern);
                $stmt->bindParam(':detail', $detail);
=======
                $stmt = $con->prepare('INSERT INTO Product(p_id, p_name, p_image, p_price, p_size, p_color, p_fabric, p_pattern, p_detail) VALUES(:p_id, :p_name, :p_image, :p_price, :p_size, :p_color, :p_fabric, :p_pattern, :p_detail )');
                $stmt->bindParam(':p_id', $p_id);
                $stmt->bindParam(':p_name', $p_name);
                $stmt->bindParam(':p_image', $p_image);
                $stmt->bindParam(':p_price', $p_price);
                $stmt->bindParam(':p_size', $p_size);
                $stmt->bindParam(':p_color', $p_color);
                $stmt->bindParam(':p_fabric', $p_fabric);
                $stmt->bindParam(':p_pattern', $p_pattern);
                $stmt->bindParam(':p_detail', $p_detail);
	  if($stmt->execute())
                {
                    $successMSG = "상품  등록되었습니다.";
                }
                else
                {
                    $errMSG = "상품  추가 에러";
                }
>>>>>>> 6c0dd5a478aba6c8eb8a4b0bb918993e1508266e
                
            } catch(PDOException $e) {
                die("Database error: " . $e->getMessage()); 
            }
        }
    }
?>