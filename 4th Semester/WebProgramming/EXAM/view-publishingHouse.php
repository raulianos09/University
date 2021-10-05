<?php
include('connection.php');
$connect = OpenConnection();

$query="";
$query = "SELECT P.name, P.URL, Count(B.idPublishingHouse) as NoOfBooks FROM publishinghouse P left join book B on B.idPublishingHouse = P.id Group By P.id";


$result = mysqli_query($connect, $query);

if(mysqli_num_rows($result)>0){
    while ($row = mysqli_fetch_array($result)){
        echo "<tr>";
        echo "<td>".$row['name']."</th>";
        echo "<td>".$row['URL']."</th>";
        echo "<td>".$row['NoOfBooks']."</th>";
        echo "</tr>";
    }

}

CloseConnection($connect);

?>