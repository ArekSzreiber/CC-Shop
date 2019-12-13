function addToCart(product_id) {
    fetch(`/add-to-cart/product/${product_id}`) // set the path; the method is GET by default, but can be modified with a second parameter
/*
        .then((response) => response.json()) // parse JSON format into JS object
*/

    let productsNumber = document.getElementById("products-number");

}

/*function getEpisodesAndActorsForSeason(season_id){
    fetch(`/season/${season_id}`)  // set the path; the method is GET by default, but can be modified with a second parameter
        .then((response) => response.json())
.then((data) => {
        displayModal(data['data']);
})
}*/
