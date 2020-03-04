<template id="planet-detail">
    <div v-if="planet" class="detail-planet-container">
        {{console.log(this.planet)}}
        <h1>{{planet.name}}</h1>
        <img v-bind:src="planet.pictureUrl" />
        <p>The mass of {{planet.name}} is {{planet.mass}} kg, it has a radius of {{planet.radius}} km,
            the eccentricity or the deviation of orbit is from a circularity is {{planet.eccentricity}}.</p>
        <p>It spins around the star {{planet.centralCelestialBody.name}} with an orbiting period of {{planet.orbitalPeriod}} days.</p>
    </div>
</template>
<script>
    Vue.component("planet-detail", {
        template: "#planet-detail",
        data: () => ({
            planet: null,
        }),
        created() {
            const planetSystemId = this.$javalin.pathParams["planet-system-id"];
            console.log("Planet system id: " + planetSystemId);
            const planetId = this.$javalin.pathParams["planet-id"];
            fetch(`/api/planet-systems/${planetSystemId}/planets/${planetId}`)

                .then(res => res.json())
                .then(res => this.planet = res)
                .catch(() => alert("Error while fetching planet"));
        }
    });
</script>
<style>
    ul{
       color:white;
    }
    div.detail-planet-container > p {
        max-width: 30em;
    }
    div.detail-planet-container{
        padding-top: 10px;
        overflow: hidden;
        width: 500px;
        background-color: #000000;
        color: white;
        margin: 0 auto;
        opacity: 0.96;
        text-align: center;
        -webkit-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        -moz-box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
        box-shadow: 10px 10px 5px 0px rgba(0,0,0,0.25);
    }

    img.planet-cover-image {
        height: 320px;
        width: 320px;
        padding-bottom: 20px;
    }

</style>