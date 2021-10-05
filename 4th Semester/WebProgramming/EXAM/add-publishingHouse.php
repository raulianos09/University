<?php
include('connection.php');
$connect = OpenConnection();


$houseName =$_POST['houseName'];
$houseURL =$_POST["houseURL"];



$query = "INSERT INTO publishinghouse (name, URL) VALUES ('$houseName', '$houseURL')";
$result = mysqli_query($connect, $query);

if (!$result)
    echo 'Could not add new publishing house!';
else
    echo 'Publishing house added successfully!';

CloseConnection($connect);

?>