new Vue({
    el: "#app",
    data: {
        see: false,
        plays: [],
        serverUrl: "http://localhost:8090/api/v1"
    },
    methods: {
        getPlays: function () {
            var self = this;

            axios.get(this.serverUrl + "/plays")
                .then(function (respons) {
                    self.plays = respons.data;
                    console.log(respons);
                })
                .catch(function (error) {
                    console.log(error);
                });

        }
    },
    mounted() {
        this.getPlays();
    }
    });