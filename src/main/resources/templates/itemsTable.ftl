<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Item</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>Item List</h3>
<a href="/index.html" class="btn btn-danger">BACK</a><br>

<br>
<div>
    <table class="table table-dark">
        <thead>
        <tr>
            <th><button class="btn btn-outline-warning" onclick="window.location.href = '/web/item/all/sort/id'">id</button></th>
            <th><button class="btn btn-outline-warning" onclick="window.location.href = '/web/item/all/sort/name'">Name</button></th>
            <th><button class="btn btn-outline-warning" onclick="window.location.href = '/web/item/all/sort/description'">description</button></th>
            <th><button class="btn btn-outline-warning" onclick="window.location.href = '/web/item/all/sort/created'">created</button></th>
            <th><button class="btn btn-outline-warning" onclick="window.location.href = '/web/item/all/sort/modified'">modified</button></th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <tbody>
        <#list items as element> <!--Цикл по всем item -->
            <!--Для каждого element в списке items, который мы получили из контролера.
            Формируем строку <tr> . У этой строки есть ..5.. ячеек.
            Каждая ячейка является полем ..елемента..! (id)(name) т.д. !!! -->

            <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}" class="btn btn-outline-danger">Delete</a> </td>
                <td><a href="/web/item/update/${element.id}" class="btn btn-outline-success">Edit</a> </td>
            </tr>
        </#list>
        </tbody>

    </table>

</div>

<a href="/web/item/create" class="btn btn-success">Create</a>


</body>
</html>