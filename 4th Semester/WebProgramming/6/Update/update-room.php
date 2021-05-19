<?php
include ('C:\Users\raul_\Desktop\ProgramareWeb\LAB\6\Resources\connection.php');
$connect = OpenConnection();

$category=$_POST['category'];
$type =$_POST['type'];
$price =$_POST['price'];
$hotel =$_POST["hotel"];
$roomID = $_POST["roomID"];

$query="";

if ($roomID != "")
    $query = " UPDATE rooms SET category = '$category', type = '$type', price ='$price' , hotel = '$hotel' WHERE roomID = '$roomID'; ";



$result = mysqli_query($connect, $query);

if (!$result)
    echo 'Room can not be updated!';
else
    echo 'Room updated!';

CloseConnection($connect);

?>