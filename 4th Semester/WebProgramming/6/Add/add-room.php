<?php
include('C:\Users\raul_\Desktop\ProgramareWeb\LAB\6\Resources\connection.php');
$connect = OpenConnection();

$category=$_POST['category'];
$type =$_POST['type'];
$price =$_POST["price"];
$hotel =$_POST["hotel"];

$query = "INSERT INTO rooms (category, type , price, hotel) VALUES ('$category', '$type', '$price', '$hotel')";
$result = mysqli_query($connect, $query);

if (!$result)
    echo 'Could not add new room!';
else
    echo 'Room added successfully!';

CloseConnection($connect);

?>