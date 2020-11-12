<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Client</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>Client List</h3>
<a href="/index.html" class="btn btn-danger">BACK</a><br>
<br>
<div>

    <table class="table table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Adress</th>
            <th>Birthday</th>
            <th>Description</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list clients as element> <!--Цикл по всем item -->
            <!--Для каждого element в списке items, который мы получили из контролера.
            Формируем строку <tr> . У этой строки есть ..5.. ячеек.
            Каждая ячейка является полем ..елемента..! (id)(name) т.д. !!! -->

            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.phone}</td>
                <td>${element.adress}</td>
                <td>${element.dateOfBirthday}</td>
                <td>${element.description}</td>
                <td><a href="/web/client/delete/${element.id}" class="btn btn-outline-danger">Delete</a> </td>
                <td><a href="/web/client/edit/${element.id}" class="btn btn-outline-success">Edit</a> </td>
            </tr>
        </#list>
        </tbody>

    </table>

    <a href="/web/client/create" class="btn btn-success">Create</a>

</div>
</body>
</html>