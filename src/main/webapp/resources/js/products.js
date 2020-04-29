$(function(){
    $.get("products", function(){
        console.log("products");
    })
})


function buyBook(id){

    console.log(id);

    $.post("buy", {'id': id}, function(){
        alert("You have just bought book");
    });
}