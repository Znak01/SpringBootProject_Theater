new Vue({
    el: "#app",
    data: {
        see: false,
        actors: [],
        serverUrl: "http://localhost:8090/api/v1"
    },
    methods: {
        getActors: function () {
            var self = this;

            axios.get(this.serverUrl + "/actors")
                .then(function (respons) {
                    self.actors = respons.data;
                    console.log(respons);
                })
                .catch(function (error) {
                    console.log(error);
                });

        }
    },
    mounted() {
        this.getActors();
    }
    });