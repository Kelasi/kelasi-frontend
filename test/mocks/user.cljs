(ns mocks.user)

(def user1
  {:profile-name "John"
   :full-name "John Doe"
   :img "/some_img.jpg"
   :email "john@doe.com"
   :timelines ["1"]
   :followed-timelines ["2" "3" "4"]
   :id "2"})

(def user2
  {:profile-name "John"
   :full-name "John Smith"
   :img "/some_img.jpg"
   :email "john@doe.com"
   :timelines ["2"]
   :followed-timelines ["1" "3" "4"]
   :id "3"})

(def user3
  {:profile-name "Jane"
   :full-name "Jane Smith"
   :img "/some_img.jpg"
   :email "jane@doe.com"
   :timelines ["3"]
   :followed-timelines ["1" "2" "4"]
   :id "4"})

(def user4
  {:profile-name "John"
   :full-name "John Hancock"
   :img "/some_img.jpg"
   :email "john@doe.com"
   :timelines ["4"]
   :followed-timelines ["1" "2" "3"]
   :id "5"})
