
function rowClicked(vaccinationID, vaccineID) {
    //location.href = "/vacc/searchDrilldown?id=" + globalVaccinationID;
    location.href = "/vacc/searchDrilldown?id=" + vaccinationID + "&vaccineID=" + vaccineID;
}

