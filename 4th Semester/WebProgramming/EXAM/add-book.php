<?php
include('connection.php');
$connect = OpenConnection();

$idPublishingHouse=$_POST['idPublishingHouse'];
$bookName =$_POST['bookName'];
$topic1 =$_POST["topic1"];
$topic2 =$_POST["topic2"];
$topic3 =$_POST["topic3"];
$topic4 =$_POST["topic4"];
$topic5 =$_POST["topic5"];


$query = "INSERT INTO book (idPublishingHouse, name , topic1, topic2, topic3, topic4, topic5) VALUES ('$idPublishingHouse', '$bookName', '$topic1', '$topic2', '$topic3', '$topic4', '$topic5')";
$result = mysqli_query($connect, $query);

if (!$result)
    echo 'Could not add new book!';
else
    echo 'Book added successfully!';

CloseConnection($connect);

?>