<?php
include('C:\Users\raul_\Desktop\ProgramareWeb\LAB\6\Resources\connection.php');
$connect = OpenConnection();

$query = "SELECT * FROM rooms";

$result = mysqli_query($connect, $query);
if(mysqli_num_rows($result)>0){
    while ($row = mysqli_fetch_array($result)){
        echo "<tr>";
        echo "<td>".$row['roomID']."</th>";
        echo "<td>".$row['category']."</th>";
        echo "<td>".$row['type']."</th>";
        echo "<td>".$row['price']."</th>";
        echo "<td>".$row['hotel']."</th>";
        echo "</tr>";
    }

}

CloseConnection($connect);

?>