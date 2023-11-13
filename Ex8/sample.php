<!DOCTYPE html>
<html>
<head>
    <title>Menu</title>
    <style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #eaeaea; 
        margin: 0;
        padding: 0;
    }
    h1 {
        text-align: center;
        color: #4682B4; 
        margin-top: 20px;
    }
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        overflow: hidden;
    }
    th, td {
        border: 1px solid #008bae; 
        padding: 12px;
        text-align: left;
    }
    th {
        background-color: #9fe7fb; 
        color: #333; 
        font-size: 18px;
    }
    tr:nth-child(odd) {
        background-color: #dbeff2;
    }
    .des {
        width: 40%;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    table:hover {
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    }
</style>



</head>
<body >
    <h1>Snowbee's Menu</h1>
    <table>
        <tr>
            <th>Dish</th>
            <th>Category</th>
            <th>Price</th>
            <th class='des'>Description</th>
        </tr>
        <?php
            $xml = simplexml_load_file('sample.xml');
            if ($xml) {
                foreach ($xml->menu as $menu) {
                    echo "<tr>";
                    echo "<td>" . $menu->dish . "</td>";
                    echo "<td>" . $menu->category . "</td>";
                    echo "<td>" . $menu->price . "</td>";
                    echo "<td>". $menu->description ."</td>";
                    echo "</tr>";
                }
            } else {
                echo "<tr><td colspan='5'>Failed to load the XML file.</td></tr>";
            }
        ?>
    </table>
</body>
</html>