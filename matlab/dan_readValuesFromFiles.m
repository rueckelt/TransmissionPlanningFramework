%values are in the form: 
%(varnames, schedulers, flows, time, networks, %repetitions)

%get schedulers from scheduler_logs (read from parameter_file.m)

function [values, avail] = dan_readValuesFromFiles( in_folder, varnames, t_max, n_max, f_max, rep_max, scheduler_logs, max_only)
%READVALUESFROMFILES Summary of this function goes here
%   Detailed explanation goes here
    [len, nof_schedulers] =size(scheduler_logs);  %length is unused
    [len, nof_values] = size(varnames);

    %reduce matrix size to avoid out of memory
    if max_only>0
        values = zeros(nof_values, nof_schedulers, 1, 1, 1,rep_max);
        avail = zeros(nof_values, nof_schedulers, 1, 1, 1,rep_max);
        f_start=f_max;
        t_start=t_max;
        n_start=n_max;
    else
        values = zeros(nof_values, nof_schedulers, f_max, t_max, n_max,rep_max);
        avail = zeros(nof_values, nof_schedulers, f_max, t_max, n_max,rep_max);
        f_start=1;
        t_start=1;
        n_start=1;
    end
    
    [nof_values, nof_schedulers, f_max, t_max, n_max,rep_max]
    state='start reading values from log data'

    for f=f_start:f_max
        round = [num2str(f) '.' num2str(f_start) '.' num2str(f_max)]
        for t = t_start:t_max
            for n = n_start:n_max
                for rep=1:rep_max
                   folders_names={'0.5_0.0', '0.2_0.0', '0.3_0.0', '0.4_0.0','0.5_0.0'};
                   %folders_names={'time_0', 'time_1','time_2', 'time_3','time_4', 'time_5','time_6', 'time_7', 'time_8', 'time_9','time_10', 'time_11','time_12', 'time_13','time_14', 'time_15','time_16', 'time_17','time_18', 'time_19','time_20', 'time_21','time_22', 'time_23','time_24', 'time_25','time_26', 'time_27','time_28', 'time_29'};

                   in_path = [in_folder filesep folders_names{t} filesep 'rep_' num2str(rep-1) filesep]
                   if exist(in_path,'dir')==7
                       addpath(in_path);    %make path accessible

                        for s=1:nof_schedulers
                           fname = [in_path scheduler_logs{s}];
                           if exist(fname, 'file') == 2 %skip non-existing files
                               run(fname);  %run script to get values
                               %store values to matrix[scheduler, flow,timeslot, network, repetition]
                               for val=1:nof_values    %skip non-existing values
                                   try
                                       if max_only>0
                                            values(val,s,1,1,1,rep) = eval(varnames{val});
                                            avail(val,s,1,1,1,rep) = 1;
                                       else
                                            values(val,s,f,t,n,rep) = eval(varnames{val});
                                            avail(val,s,f,t,n,rep) = 1;
                                       end
                                   catch
    %                                    values(val, s,f,t,n,rep) = 0;
    %                                    ['failed to read: ' fname ': ' varnames{val}]
                                   end
                               end
                           else
                               err=['file not found' fname]
                           end
                           clearvars -except in_path values avail max_only n_start f_start t_start varnames t n f s rep t_max n_max f_max rep_max scheduler_logs nof_values nof_schedulers in_folder out_folder
                        end
                       rmpath(in_path);
                   end
               end 
            end
        end
     end
end

