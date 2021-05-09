
// Used to remove the commas (symbol) from the vaccines string
function removeSymbol(symbol, str){
    var newString = "";
    for(var i = 0; i < str.length; i++) {
        var char = str.charAt(i);
        if(char != symbol){
            newString = newString + char;
        }
    }
    // Storing the procesed string into a new string and removing whitespace
    const trimmedText = newString.split(/\s/).join('');
    
    // Adding numbers to array
    const array = Array.from(trimmedText);
    return array;
}

function displayImages(array){
    const imageSources = array;

    imageSources.forEach(element => {
        var img = document.createElement("img");
        img.width = '300';
        img.height = '300';
        img.class = 'img-responsive';
        img.src = "/assets/images/" + element + ".jpg";
        document.getElementById("picture").appendChild(img);
    });
}
