membershipManager.provider('Member', function() {
        this.$get = ['$resource', function($resource) {
            var Member = $resource('/member/:_id', {}, {
                update: {
                    method: 'PUT'
                }
            })

            return Member;
        }];
    });