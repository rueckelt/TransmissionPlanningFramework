%matlab eval for scheduling

%stores results.mat file in in_folder for extracted log matrices
%delete this file to read logs from raw files

in_folder = '../08_11_Accuracy8_n8_t100/CombinedUncertainty';% 'logs_time';
%in_folder = '..\my_logs\eval_4_4_3_c10';% 'logs_time';
%in_folder = '../20_11_Converge/GA2';% 'logs_time';

out_folder = [in_folder filesep 'tikz_t_big'];
force_read_data = 0;
max_only=0;



%get paramters from file
parameter_file=[in_folder filesep 'parameters_log.m'];
assert(exist(parameter_file, 'file') ==2, 'file not found');
if exist(parameter_file, 'file') ==2    %compare to 2 == is a file?
   run(parameter_file);
   max_flows=max_flows;
   max_nets=max_nets;
   max_time=max_time;
end
max_time=1
max_rep = 30
%folders={'0.3_10.0', '0.5_10.0', '0.5_5.0', '0.7_10.0', '0.7_15.0', '0.7_5.0'};
state = 'read param done'
%read matrix file if available, else create matrix file from raw log files

valuenames = {'violation cost', 'execution duration', 'time limits',...
     'min. throughput','unscheduled tokens', 'latency jitter','monetary cost'};
% valuenames = {'cost', 'duration', 'time_limits', ...
%     'throughput', 'unscheduled', 'latency_jitter', 'monetary_cost'};
data_file=[in_folder filesep 'results.mat'];
avail_file=[in_folder filesep 'avail.mat'];

if force_read_data <1 && exist(data_file, 'file') %read values from file if no force to reread and available
    load(data_file);
    load(avail_file);
else
    %read data from simulation output files
    valuestrings = { 'costTotal','scheduling_duration_us', 'sum(vioSt)+sum(vioDl)', ...
        'sum(vioTp)', 'sum(vioNon)', 'sum(vioLcy)+sum(vioJit)', 'cost_ch'};
    tic
    [raw_values, avail] = dan_readValuesFromFiles( in_folder, valuestrings,...
        max_time, max_nets, max_flows, max_rep, scheduler_logs, max_only);
    toc
    save(data_file, 'raw_values');
    save(avail_file, 'avail');
end
raw_values(2,:,:,:,:,:)=raw_values(2,:,:,:,:,:)./(1000*1000);     %time: �s to seconds
state='gathered data'
%calculate relative
% %plot
%rel_data = relative_to_opt(raw_values);
%save('rel_data.mat', 'rel_data');


dan_plot_data3(out_folder, raw_values, avail, valuenames, schedulers);  %vary time
%plot_data4(out_folder, raw_values, avail, valuenames, schedulers);  %vary networks
% 
state='done'


%The functions you mention return H=0 when a test cannot reject the hypothesis of a normal distribution.
%Kolmogorow-Smirnow-Test kstest
%Anderson-Darling-Test adtest
%Lilliefors-Test [h,p,k,c] = lillietest()

