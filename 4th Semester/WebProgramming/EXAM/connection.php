<?php
function OpenConnection(): mysqli
{
    return mysqli_connect("localhost", "root", "", "exam");
}

function CloseConnection(mysqli $con)
{
    $con->close();
}
?>