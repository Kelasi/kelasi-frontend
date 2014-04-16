
namespace :publish do

  desc 'Clone kelasi-public repository to public dir'
  task :init do
    sh "git clone git@github.com:Kelasi/kelasi-public.git public"
  end
end

desc 'Compile all files and copy them to their destinations in public dir'
task :publish do
  sh "lein with-profile production cljsbuild once"
end
