<?php
include('connection.php');
$connect = OpenConnection();

$idPublishingHouse=$_POST['idPublishingHouse'];


$query = " Select * from book where idPublishingHouse = '$idPublishingHouse'";
$result = mysqli_query($connect, $query);
if (mysqli_num_rows($result) == 0)
{
    $query = "DELETE FROM publishinghouse WHERE id = '$idPublishingHouse'";
    $result = mysqli_query($connect, $query);
    echo 'Publishing house was  deleted!';
}
else
    echo 'Publishing house cannot be deleted!';

CloseConnection($connect);

?>